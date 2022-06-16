package com.yazid.assessment3.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yazid.assessment3.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM tbl_user ORDER BY id ASC")
    fun getAllUser(): LiveData<List<User>>

    @Query("SELECT * FROM tbl_user WHERE id = :id")
    fun getOneUser(id: Long): LiveData<User>

    @Query("SELECT * FROM tbl_user WHERE username = :username")
    fun getUserByUsername(username: String): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)
}