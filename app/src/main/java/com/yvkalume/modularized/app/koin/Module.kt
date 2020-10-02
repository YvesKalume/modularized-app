package com.yvkalume.modularized.app.koin

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.yvkalume.model.api.PostApi
import com.yvkalume.model.repository.PostRepository
import com.yvkalume.modularized.ui.post.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        PostViewModel(get())
    }
}

val repositoryModule = module {
    single {
        PostRepository(get())
    }
}

val apiModule = module {
    fun providePostApi(retrofit: Retrofit) : PostApi {
        return retrofit.create(PostApi::class.java)
    }

    single { providePostApi(get()) }
}

val retrofitModule = module {
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
    }

    single { provideRetrofit() }
}

val myModules = listOf(viewModelModule, repositoryModule, apiModule, repositoryModule, retrofitModule)