package com.example.practice8_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice8_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass:ActivityMainBinding  //создаем переменную для binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)  //надуваем наш binding
        setContentView(bindingClass.root)  //отображаем контент с него

        bindingClass.buttonFragOne.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.place_holder, BlankFragment2.newInstance()).commit()  //запускаем второй фрагмент
        }  //слушатель нажатий на кнопку

        bindingClass.buttonfragTwo.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.place_holder, BlankFragment()).commit()
        }

        supportFragmentManager.beginTransaction().replace(R.id.place_holder, BlankFragment()).commit()  //отображаем наш фрагмент, beginTransaction() для запуска фрагмента, replace() - заменяет тот фрагмент который есть уже в контейнере на новый, указываем путь до фрагмента в xml и инстанцию фрагмента(название его) в kt.
        // supportFragmentManager.beginTransaction().replace(R.id.place_holder, BlankFragment.newInstance).commit()  // или  так. commit() применяет все это
    }
}