package com.itis.androidsummerpractice
/*
Инструкции
Нужно сделать SingleActivity приложение. В активити находится контейнер
для фрагментов и bottomNavigationView.

BottomNavigationView состоит из 5 различных элементов. У каждого своя иконка и свой label.

Каждому элементу меню соотвествующий фрагмент. Навигация работает через NavComponent.
NavController должен сетиться в bottomNavigationView.

Из любого из 5 фрагментов можно сделать навигацию на фрагмент,
который не является частью BottomNavigationView.
В этот фрагмент нужно передать как аргумент название класса, с которого его вызвали.
Далее, этот аргумент нужно отобразить на экране с помощью Snackbar. Пример вызова snackbar.

Snackbar.make(binding.root, "TEST", Snackbar.LENGTH_LONG).show()

Fragments:
Home
Content
Profile
Friends
Favorites

 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.itis.androidsummerpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newBinding = ActivityMainBinding.inflate(layoutInflater)
        binding = newBinding
        setContentView(newBinding.root)
        val controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        findViewById<BottomNavigationView>(R.id.bnv_main).apply {
            setupWithNavController(controller)
        }
    }
}
