package com.example.bookslibrary
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import com.example.bookslibrary.databinding.HomePageBinding
import com.example.bookslibrary.ui.theme.BooksAdapter
import com.example.bookslibrary.ui.theme.BooksLibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding: HomePageBinding = DataBindingUtil
            .setContentView(this, R.layout.home_page)

        var books = mutableListOf<Books>(
            Books(R.drawable.angels, "Angels and Demons", "by Dan Brown"),
            Books(R.drawable.blood, "BloodLine", "by james Rollins"),
            Books(R.drawable.humming, "The Hummingbird's Daughter", "by Luis Alberto Urrea"),
            Books(R.drawable.nostra, "Terra Nostra", "by Carios Fuentes"),
            Books(R.drawable.solitude, "One Hundered Years of Solitude", "by Gabriel García Márquez"),
            Books(R.drawable.spirits, "The House of Spirits", "by Isabel Allende"),
            Books(R.drawable.sword, "The Sword Thief", "by Peter Lerangis"),
        )

        var bookAdapter = BooksAdapter(books)
        binding.bookRv.adapter = bookAdapter

        binding.toolbar.materialToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.notification -> {
                    Toast.makeText(this, R.string.notification, Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

        binding.navigationMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.reviews->{
                    Toast.makeText(this, R.string.reviews, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.favorites->{
                    Toast.makeText(this, R.string.favorites, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.search_book->{
                    Toast.makeText(this, R.string.search_book, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.profile->{
                    Toast.makeText(this, R.string.profile, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.settings->{
                    Toast.makeText(this, R.string.settings, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                else -> false
            }
        }

        binding.toolbar.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }
    }
}

