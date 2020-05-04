package com.nbali.alinadi.shahabmousaviapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RProduct (
    @PrimaryKey(autoGenerate = false) var id:Int,
    @ColumnInfo var name:String,
    @ColumnInfo var content:String,
    @ColumnInfo var image:String,
    @ColumnInfo var link:String,
    @ColumnInfo var amount_app:String,
    @ColumnInfo var amount:String
)