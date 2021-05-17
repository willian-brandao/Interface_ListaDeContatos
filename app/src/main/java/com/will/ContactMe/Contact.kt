package com.will.ContactMe

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//class to represent each contact
//parcelize made class able to trafficked between views

@Parcelize
data class Contact(
    var name: String,
    var phone: String,
    var photograph: String
):Parcelable