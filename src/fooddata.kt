package app

import foodlist

class app (var creatorname : String? = null) {

    private var fooddata = listOf (
        foodlist (
            numberfood = 1,
            namefood = "Ayam bakar " ,
            pricefood = 50000.0
        ),//food 1
        foodlist (
            numberfood = 2 ,
            namefood = "Ayam Goreng",
            pricefood = 40000.0
        ),//food 2
        foodlist (
            numberfood = 3,
            namefood = "Ayam Geprek",
            pricefood = 40000.0
        ),//food 3
        foodlist (
            numberfood = 4,
            namefood = "Kulit Ayam Crispy",
            pricefood = 15000.0
        ),//food 4
        foodlist (
            numberfood = 5,
            namefood = "Sate Usus Ayam",
            pricefood = 5000.0
        )//food 5
    )
    private var selectedfood : foodlist? = null

    fun run () {
        printheader()
        getselectedfood()
    }
    private fun printheader(){
        println("-------------------------------")
        println(" List menu makanan ")
        println("-------------------------------")
        fooddata.forEachIndexed { index, data ->
            println("${index+1}.${data.namefood} : Rp ${data.pricefood}/porsi")
        }//lambda function
        println("-------------------------------")
    }

    private fun getselectedfood(){


        println("pilih menu makanan ? (1/2/3/4/5) ")

        try {
            //milih menu
            val selectedindex = readln().toInt()

            if (selectedindex in 1..fooddata.size) {
                selectedfood = fooddata[selectedindex - 1]

                println("kamu memilih menu  ${selectedfood?.numberfood}")
                println("Nama menu : ${selectedfood?.namefood}")
                println("Harga : Rp. ${selectedfood?.pricefood}")

                //masukan pembayaran
                println("masukan pembayaran")

                var payment : Double? = null

                while (payment == null || payment < selectedfood?.pricefood!!){
                    val paymentinput = readLine()
                    payment = paymentinput?.toDoubleOrNull()

                if (payment == null || payment < selectedfood?.pricefood!!) {
                    println("Maaf pembayaran anda gagal")
                    println("masukan pembayaran ")
                    }
                }
            } else {
                println("Terimakasih , anda berhasil memesan makanan ")
            }
            //menampilkann menu yang dipilih beserta harga
            val selectedfood = fooddata[selectedindex - 1]
            val totalprice = selectedfood.pricefood

            println("-------------------------------")
            println("total harga  = Rp $totalprice")
            println("-------------------------------")

            //pilihan take away/delivery
            println("1.Take away")
            println("2.Delivery")
            println("pilih metode pengiriman makanan ! (1/2)")

            val deliveryoption = readLine()?.toIntOrNull()

            when (deliveryoption) {
                1 -> {
                    println("Makananmu sedang dimasak (5 detik).....")
                    Thread.sleep(5000) // Delay selama 5 detik
                    println("Makananmu sudah siap! Silahkan ambil di resto ya! (5 detik).....")
                    Thread.sleep(5000) // Delay selama 5 detik
                    println("Pesanan selesai! (3 detik)...")
                }
                2 -> {
                    println("Makananmu sedang dimasak (5 detik).....")
                    Thread.sleep(5000) // Delay selama 5 detik
                    println("Makananmu sudah siap! Driver segera menuju tempatmu! (5 detik).....")
                    Thread.sleep(5000) // Delay selama 5 detik
                    println("Driver sampai! pesanan selesai! (3 detik)...")
                }
                else -> println("Pilihan tidak valid. Pengambilan dianggap Take Away.")
            }
        }
        catch (e: NumberFormatException){
            println("you input wrong value ")
            printheader()
            getselectedfood()//recursive
        }
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            app("nope").run()
        }
    }
}