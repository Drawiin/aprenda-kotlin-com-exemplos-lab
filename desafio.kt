// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

data class Formation(
    val name: String,
    val level: Level,
    val content: List<EdContent>,
    val students: List<Student> = emptyList()
)


enum class Level { BEGINER, INTERMETIATE, ADVANCED }

data class EdContent(val name: String, val durationInMinutes: Int = 60)

data class Student(val name: String)


class EnrollStudentInteractor(private var formation: Formation) {
    fun addStudent(student: Student) {
        formation = formation.copy(
            students = formation.students + student
        )
    }

    fun getStudents() = formation.students

    fun getFormationStatus() = "formatioin status -> \n $formation"
}

fun main() {
    val enrollStudentsInteractor = EnrollStudentInteractor(
        Formation(
            name = "Kotlin",
            level = Level.INTERMETIATE,
            content = listOf(
                EdContent("Dependency Injection", 30)
            )
        )
    )



    (1..10).forEach {
        enrollStudentsInteractor.addStudent(Student("student $it"))
    }

    println(enrollStudentsInteractor.getStudents())
    println(enrollStudentsInteractor.getFormationStatus())

}
