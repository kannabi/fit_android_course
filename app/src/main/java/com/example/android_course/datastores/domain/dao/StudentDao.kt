package com.example.android_course.datastores.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.android_course.datastores.model.GroupWithStudents
import com.example.android_course.datastores.model.Student
import com.example.android_course.datastores.model.StudentAndJournal
import com.example.android_course.datastores.model.StudentInfo
import com.example.android_course.datastores.model.StudentJournalEntries

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg students: Student)

    @Delete
    fun delete(student: Student): Int // возвращаемое значение опционально, возвращает количество удаленных срок

    @Query("SELECT * FROM Student")
    fun getAll(): List<Student>

    @Query("SELECT * FROM Student WHERE full_name = :name")
    fun findByName(name: String): List<Student>
//
    @Query("SELECT full_name, stk, balance FROM Student")
    fun getStudentInfo(): List<StudentInfo>

    @Transaction
    @Query("SELECT * FROM Student")
    fun getStudentAndJournal(): List<StudentAndJournal>

    @Transaction
    @Query("SELECT * FROM StudentJournal")
    fun getJournalAndEntries(): List<StudentJournalEntries>

    @Transaction
    @Query("SELECT * FROM StudentGroup")
    fun getGroupWithStudents(): List<GroupWithStudents>
}