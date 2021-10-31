package com.example.android_course.datastores.model

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(indices = [Index("full_name")])
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int,
    // ColumnInfo опционально, если нам не нужно ничего кастомизировать
    @ColumnInfo(name = "full_name") val name: String,
    val avatarUrl: String,
    val stk: String,
    val balance: Int,
    val educationServiceId: Int,
    val phone: String,
    val email: String,
    @Embedded val address: Address
)

data class Address(
    val countryCode: String,
    val cityCode: String,
    val street: String
)

data class StudentInfo(
    @ColumnInfo(name = "full_name") val name: String,
    val stk: String,
    val balance: Int
)

@DatabaseView("SELECT full_name, stk, balance, avatarUrl, phone, email FROM Student")
data class StudentInfoExtended(
    @ColumnInfo(name = "full_name") val name: String,
    val stk: String,
    val balance: Int,
    val avatarUrl: String,
    val phone: String,
    val email: String
)

@Entity
class StudentJournal(
    @PrimaryKey(autoGenerate = true) val journalId: Int,
    val studentId: Int,
)

class StudentAndJournal(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "id",
        entityColumn = "studentId"
    )
    val journal: StudentJournal
)

@Entity
class StudentJournalEntry(
    @PrimaryKey(autoGenerate = true) val entryId: Int,
    val journalId: Int,
    val desciption: String
)

class StudentJournalEntries(
    @Embedded val studentJournal: StudentJournal,
    @Relation(
        parentColumn = "journalId",
        entityColumn = "journalId"
    )
    val studentJournalEntries: List<StudentJournalEntry>
)

@Entity
data class StudentGroup(
    @PrimaryKey val groupId: Int,
    val name: String
)

@Entity(primaryKeys = ["id", "groupId"])
data class StudentToGroupCrossRef(
    val id: Int,
    val groupId: Int
)


data class GroupWithStudents(
    @Embedded val group: StudentGroup,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "id",
        associateBy = Junction(StudentToGroupCrossRef::class)
    )
    val students: List<Student>
)