package com.pe.relari.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pe.relari.myapplication.business.model.business.Employee
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_employee.view.*


private const val MALE_CODE = "M"
private const val IMAGE_MALE: String = "https://cdn.icon-icons.com/icons2/1465/PNG/512/154manofficeworker2_100459.png"
private const val IMAGE_FEMALE: String = "https://cdn.icon-icons.com/icons2/1465/PNG/512/156womanofficeworker2_100687.png"

class EmployeeAdapter(
    private val listEmployees: List<Employee>) : RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EmployeeHolder(layoutInflater.inflate(R.layout.item_employee, parent, false))
    }

    override fun getItemCount(): Int = listEmployees.size

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        holder.render(listEmployees[position])
    }

    class EmployeeHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun render(Employee: Employee) {
            view.tvName.text = Employee.name
            view.tvPosition.text = Employee.position

            if (MALE_CODE == Employee.sex) {
                Picasso.get().load(IMAGE_MALE).into(view.imgSex)
            } else {
                Picasso.get().load(IMAGE_FEMALE).into(view.imgSex)
            }

        }
    }
}