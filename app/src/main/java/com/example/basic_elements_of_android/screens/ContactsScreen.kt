package com.example.basic_elements_of_android.screens

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.provider.ContactsContract
import android.service.voice.VoiceInteractionSession.ActivityId
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import kotlin.coroutines.coroutineContext

@Composable
fun ContactsScreen() {
    val context = LocalContext.current
    val activity = if (context is Activity) context else null
    val list = mutableListOf<String>()

    checkPermissions(activity, context) {
        activity?.let {
            getContacts(activity).let { list.addAll(it) }
        }
    }
    Log.d("checkData", "Contacts size: ${list.size}")
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(top = 30.dp)
    ) {
        Text(text = "Contacts Screen")
        LazyColumn {
            items(list) { contactName ->
                Text(
                    text = contactName,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

fun checkPermissions(activity: Activity?, context: Context, success:() -> Unit) {
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
        activity?.let {
            ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.READ_CONTACTS), 1)
        }
    }
    else {
        success()
    }
}

fun getContacts(activity: Activity?): List<String> {
    val list: MutableList<String> = ArrayList()

    val projection = arrayOf(ContactsContract.Data.DISPLAY_NAME_PRIMARY)
    val cursor = activity?.contentResolver?.query( // Обращение к ContentProvider
        ContactsContract.Data.CONTENT_URI,
        projection,
        null, null, null
    )

    if (cursor != null && cursor.moveToFirst()) {
        for (j in 0 until cursor.count) {
            for (i in 0 until cursor.columnCount) {
                list.add(cursor.getString(i))
                cursor.moveToNext()
            }
        }
        cursor.close()
    }

    return list.toList()
}