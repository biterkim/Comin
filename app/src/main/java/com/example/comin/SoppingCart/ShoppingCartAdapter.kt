package com.example.comin.SoppingCart

//img:음식 사진 name:음식 이름, price:음식 가격, total_price:음식 별 총금액, delete_button: 삭제버튼,
class ShoppingCartAdapter(val img: String, val name: String, val price: String, total_price:String, val delete_button: String  ) {

    var cartList = arrayListOf<ShoppingCartAdapter>()
}