package com.example.android_course.datastores.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_course.datastores.domain.dao.StudentDao
import com.example.android_course.datastores.model.Student
import com.example.android_course.datastores.model.StudentGroup
import com.example.android_course.datastores.model.StudentInfoExtended
import com.example.android_course.datastores.model.StudentJournal
import com.example.android_course.datastores.model.StudentJournalEntry
import com.example.android_course.datastores.model.StudentToGroupCrossRef

@Database(
    entities = [
        Student::class,
        StudentJournal::class,
        StudentJournalEntry::class,
        StudentGroup::class,
        StudentToGroupCrossRef::class
   ],
    version = 1,
    views = [StudentInfoExtended::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}