package pl.mobicons.aimealplanner.di

import android.app.Application
import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.mobicons.aimealplanner.Config
import pl.mobicons.aimealplanner.data.RecipeService
import pl.mobicons.aimealplanner.data.RecipeServiceMock
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideMoshi() = Moshi.Builder().build()

    @Provides
    fun provideOkHttpClient(application: Application): OkHttpClient = OkHttpClient.Builder()
        .cache(Cache(application.cacheDir, 10 * 10 * 1024))
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("https://dummy.url")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    fun provideRetrofitMock(retrofit: Retrofit) = MockRetrofit.Builder(retrofit)
        .networkBehavior(NetworkBehavior.create())
        .build()

    @Provides
    fun provideRecipeService(
        @ApplicationContext context: Context,
        moshi: Moshi,
        retrofit: Retrofit,
        mockRetrofit: MockRetrofit
    ): RecipeService =
        if (Config.MOCK) {
            val delegate = mockRetrofit.create(RecipeService::class.java)
            RecipeServiceMock(context, moshi, delegate)
        } else {
            retrofit.create()
        }
}