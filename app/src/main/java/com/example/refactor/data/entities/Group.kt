package com.example.refactor.data.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "Group")
@TypeConverters(GroupTypeConverters::class)
data class Group(
    @PrimaryKey(autoGenerate = true) val groupId: Long = 0,
    val groupName: String,
    val contactIdList: List<Long>
) : Parcelable {
    companion object {
        const val ALL_CONTACTS_ID = -2L

        @JvmField
        val CREATOR = object : Parcelable.Creator<Group> {
            override fun createFromParcel(parcel: Parcel): Group {
                return Group(parcel)
            }

            override fun newArray(size: Int): Array<Group?> {
                return arrayOfNulls(size)
            }
        }
    }

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: "",
        parcel.createLongArray()?.toList() ?: emptyList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(groupId)
        parcel.writeString(groupName)
        parcel.writeLongArray(contactIdList.toLongArray())
    }

    override fun describeContents(): Int {
        return 0
    }
}
