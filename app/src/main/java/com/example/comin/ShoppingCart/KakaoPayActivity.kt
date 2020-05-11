package com.example.comin.ShoppingCart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.comin.MainActivity
import com.example.comin.R
import kr.co.bootpay.Bootpay
import kr.co.bootpay.BootpayAnalytics
import kr.co.bootpay.enums.Method
import kr.co.bootpay.enums.PG
import kr.co.bootpay.enums.UX
import kr.co.bootpay.listener.CancelListener
import kr.co.bootpay.listener.CloseListener
import kr.co.bootpay.listener.ConfirmListener
import kr.co.bootpay.listener.DoneListener
import kr.co.bootpay.listener.ErrorListener
import kr.co.bootpay.listener.ReadyListener
import kr.co.bootpay.model.BootExtra
import kr.co.bootpay.model.BootUser

class KakaoPayActivity : AppCompatActivity() {
    //

    val stuck=10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var intent = intent//=getIntent()
        var menu = intent.getStringExtra("menu")
        var price = intent.getIntExtra("price", 0)


        BootpayAnalytics.init(this, "59a4d326396fa607cbe75de5")
        kakaoPay(menu, price)
    }

    fun kakaoPay(menu: String, price: Int) {
        // 결제호출
        var bootUser = BootUser().setPhone("010-1234-5678");
        var bootExtra = BootExtra().setQuotas(IntArray(3) { 0;2;3 })//할부
        Bootpay.init(getFragmentManager())
            .setApplicationId("59a4d326396fa607cbe75de5") // 해당 프로젝트(안드로이드)의 application id 값
            .setPG(PG.KAKAO) // 결제할 PG 사
            .setMethod(Method.EASY) // 결제수단
            .setContext(this)
            .setBootUser(bootUser)
            .setBootExtra(bootExtra)
            .setUX(UX.PG_DIALOG)
//                .setUserPhone("010-1234-5678") // 구매자 전화번호
            .setName(menu) // 결제할 상품명
            .setOrderId("1234") // 결제 고유번호expire_month -> 주문내역 고유 아이디 ex)2020-05-08-1234
            .setPrice(price) // 결제할 금액
            /*.addItem("마우's 스", 1, "ITEM_CODE_MOUSE", 100) // 주문정보에 담길 상품정보, 통계를 위해 사용
            .addItem(
                "키보드",
                1,
                "ITEM_CODE_KEYBOARD",
                200,
                "패션",
                "여성상의",
                "블라우스"
            ) // 주문정보에 담길 상품정보, 통계를 위해 사용*/
            .onConfirm(ConfirmListener {
                // 결제가 진행되기 바로 직전 호출되는 함수로, 주로 재고처리 등의 로직이 수행
                if (0 < stuck) Bootpay.confirm(it); // 재고가 있을 경우.
                else Bootpay.removePaymentWindow(); // 재고가 없어 중간에 결제창을 닫고 싶을 경우
            })
            .onDone(DoneListener {
                // 결제완료시 호출, 아이템 지급 등 데이터 동기화 로직을 수행합니다
                finish()
            })
            .onReady(ReadyListener {
                // 가상계좌 입금 계좌번호가 발급되면 호출되는 함수입니다.

            })
            .onCancel(CancelListener {
                // 결제 취소시 호출
                finish()

            })
            .onError(ErrorListener {
                // 에러가 났을때 호출되는 부분
                Log.d("test",it)
                finish()

            })
            .onClose(CloseListener {
                //결제창이 닫힐때 실행되는 부분
                finish()
            })
            .request();
    }
}