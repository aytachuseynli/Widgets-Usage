package com.aytachuseynli.widgetusage

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import com.aytachuseynli.widgetusage.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switch1.setOnCheckedChangeListener { view, booleanResult->
            if (booleanResult) {
              Log.e("Widgets", "Switch : ON")
            }else {
                Log.e("Widgets", "Switch : OFF")
            }
        }

        binding.checkBox.setOnCheckedChangeListener { view, booleanResult->
            if (booleanResult) {
                Log.e("Widgets", "CheckBox : ON")
            }else {
                Log.e("Widgets", "CheckBox : OFF")
            }
        }

        binding.radioButtonBarcelona.setOnCheckedChangeListener { view, booleanResult->
            if (booleanResult) {
                Log.e("Widgets", "Barcelona : ON")
            }else {
                Log.e("Widgets", "Barcelona : OFF")
            }
        }

        binding.radioButtonRealMadrid.setOnCheckedChangeListener { view, booleanResult->
            if (booleanResult) {
                Log.e("Widgets", "RealMadrid : ON")
            }else {
                Log.e("Widgets", "RealMadrid : OFF")
            }
        }

        binding.buttonStart.setOnClickListener{
            binding.progressBar.visibility = View.VISIBLE
        }

        binding.buttonStop.setOnClickListener{
            binding.progressBar.visibility = View.INVISIBLE
        }

        binding.slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
              binding.textViewResult.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })

        binding.buttonTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val dp = DatePickerDialog(this,{ t, y, m, d ->
                binding.textViewResult.text = "$d/${m+1}/$y"
            },year,month,day).show()
        }

        val countries = ArrayList<String>()
        countries.add("Turkey")
        countries.add("Azerbaijan")
        countries.add("Italy")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,countries)
        binding.spinner.adapter = adapter

        binding.buttonToast.setOnClickListener{
         Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
        }

        binding.buttonAlert.setOnClickListener{
          val ad = AlertDialog.Builder(this)
          ad.setTitle("Title")
          ad.setMessage("Message")

            ad.setPositiveButton("OK"){d,i ->
                Toast.makeText(this,"OK Selected",Toast.LENGTH_SHORT).show()
            }

            ad.setNegativeButton("Cancel"){d,i ->
                Toast.makeText(this,"Cancel Selected",Toast.LENGTH_SHORT).show()
            }

            ad.create().show()
        }

        binding.buttonShow.setOnClickListener{
            Log.e("Widgets", "Switch last state : ${binding.switch1.isChecked}")
            Log.e("Widgets", "CheckBox last state : ${binding.checkBox.isChecked}")
            Log.e("Widgets", "Barcelona last state : ${binding.radioButtonBarcelona.isChecked}")
            Log.e("Widgets", "RealMadrid last state : ${binding.radioButtonRealMadrid.isChecked}")
            Log.e("Widgets", "Slider last state : ${binding.slider.progress}")
            Log.e("Widgets", "Spinner last state : ${binding.spinner.selectedItem}")


        }
    }
}