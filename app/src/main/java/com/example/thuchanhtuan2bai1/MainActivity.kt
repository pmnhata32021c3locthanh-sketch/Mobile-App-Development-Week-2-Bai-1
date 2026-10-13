
package com.example.thuchanhtuan2bai1

import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Student(
    val name: String,
    val email: String?,
    val phone: String?
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentList = findViewById<LinearLayout>(R.id.studentList)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        val students = listOf(
            Student("Nguyễn Văn An", "an@sv.edu.vn", "0901 234 567"),
            Student("Trần Thị Bình", null, "0912 888 999"),
            Student("Lê Minh Chi", "chi@sv.edu.vn", null),
            Student("Phạm Quốc Dũng", null, null),
            Student("Võ Thanh Em", "em@sv.edu.vn", "0933 111 222")
        )

        var missingEmail = 0

        for (student in students) {

            if (student.email == null) {
                missingEmail++
            }

            val card = LinearLayout(this)
            card.orientation = LinearLayout.VERTICAL
            card.setPadding(16, 14, 16, 14)
            card.setBackgroundColor(Color.WHITE)

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.bottomMargin = 12
            card.layoutParams = params

            val name = TextView(this)
            name.text = student.name
            name.textSize = 17f
            name.setTextColor(Color.BLACK)
            name.setTypeface(null, Typeface.BOLD)

            val email = TextView(this)
            email.text = "Email: ${student.email ?: "Chưa cập nhật"}"
            email.textSize = 14f

            val phone = TextView(this)
            phone.text = "SĐT: ${student.phone ?: "Chưa cập nhật"}"
            phone.textSize = 14f

            card.addView(name)
            card.addView(email)
            card.addView(phone)

            studentList.addView(card)
        }

        txtTotal.text =
            "Tổng: ${students.size} sinh viên     Thiếu email: $missingEmail"
    }
}
