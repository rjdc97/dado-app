package edu.itesm.dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var tiros = 0
    var player1 = 0
    var player2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("edu.itesm.daec", "demostración de log")
        //test_kotlin(
        tira_dado()
    }
    fun tira_dado(){
        if(tiros==0){
            mensaje.text = "Iniciar juego de dados, presiona el boton para tirar el dado para el player 1"
            roll_dice.text = "Turno: Player 1"
        }
        roll_dice.setOnClickListener{
            tiros++
            if(tiros==1 || tiros==3 || tiros==5){
                mensaje.text = "Tiro del player 1"
                val rand = Random.nextInt(1, 6)
                player1 = player1 + rand
                mensaje.text = "El resultado del tiro fue: $rand, el global del player 1 es $player1. Presiona el boton para tirar el dado para el player 2"
                roll_dice.text = "Turno: Player 2"
            }
            if(tiros==2 || tiros==4 ){
                mensaje.text = "Tiro del player 2"
                val rand = Random.nextInt(1, 6)
                player2 = player2 + rand
                mensaje.text = "El resultado del tiro fue: $rand, el global del player 2 es $player2. Presiona el boton para tirar el dado para el player 1"
                roll_dice.text = "Turno: Player 1"
            }
            if(tiros==6){
                mensaje.text = "Tiro del player 2"
                val rand = Random.nextInt(1, 6)
                player2 = player2 + rand
                mensaje.text = "El resultado del tiro fue: $rand, el global del player 2 es $player2. Presiona el boton para ver el ganador"
                roll_dice.text = "Ver ganador"
            }
            if(tiros==7) {
                var resultado = if (player1 > player2) {
                    "El player 1 es el ganador"
                } else if (player2 > player1) {
                    "El player 2 es el ganador"
                } else {
                    "Fue un empate"
                }
                mensaje.text = resultado
                roll_dice.text = "Nuevo juego"
                player1 = 0
                player2 = 0
                tiros = 0
            }
        }
    }
}