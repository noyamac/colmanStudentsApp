import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.colman.studentlist.R
import com.colman.studentlist.model.Student

class studentAdapter(
    private val studentList: MutableList<Student>?
) : RecyclerView.Adapter<StudentRowViewHolder>() {
    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentRowViewHolder {
        val inflator = LayoutInflater.from(parent.context).inflate(R.layout.student_row_layout, parent, false)
        return StudentRowViewHolder(inflator, listener)
    }

    override fun getItemCount(): Int = studentList?.size ?: 0

    override fun onBindViewHolder(holder: StudentRowViewHolder, position: Int) {
        studentList?.get(position)?.let { holder.bind(it) }
    }
}