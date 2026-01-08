package com.example.myfirebase.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.myfirebase.view.components.SiswaTopAppBar
import com.example.myfirebase.view.route.DestinasiEdit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun editSiswaScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    ){
    Scaffold(
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiEdit.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp

            )
        },
        modifier = modifier
    ) { innerPadding ->
        val caroutineScope = rememberCoroutineScope ()

    }
}