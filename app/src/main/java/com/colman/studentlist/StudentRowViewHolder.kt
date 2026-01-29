import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.colman.studentlist.R
import com.colman.studentlist.model.Model
import com.colman.studentlist.model.Student

interface OnItemClickListener {
    fun onItemClick(position: Int)
    fun onStudentClick(student: Student?, position: Int)
}

class StudentRowViewHolder(itemView: View, listener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {
    private val studentNameTextView: TextView = itemView.findViewById(R.id.studentNameTextView)
    private val studentIdTextView: TextView = itemView.findViewById(R.id.studentIdTextView)
    private val studentCheckBox: CheckBox = itemView.findViewById(R.id.studentCheckBox)
    private var student: Student? = null

    init {
        studentCheckBox.setOnClickListener {
            val currentStudent = Model.shared.students[bindingAdapterPosition]
            currentStudent.isPresent = studentCheckBox.isChecked
        }

        itemView.setOnClickListener {
            Log.i("TAG", "StudentRowViewHolder: Clicked on position $bindingAdapterPosition")
            listener?.onItemClick(bindingAdapterPosition)
            listener?.onStudentClick(student, bindingAdapterPosition)
        }
    }

    fun bind(student: Student?) {
        this.student = student
        studentNameTextView.text = student?.name
        studentIdTextView.text = student?.id
        studentCheckBox.isChecked = student?.isPresent ?: false
    }
}