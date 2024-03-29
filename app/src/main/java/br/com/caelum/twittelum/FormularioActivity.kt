package br.com.caelum.twittelum

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelum.modelo.Tweet
import br.com.caelum.twittelum.util.toBase64
import br.com.caelum.twittelum.viewmodel.TweetViewModel
import br.com.caelum.twittelum.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class FormularioActivity : AppCompatActivity() {

    private var caminho: String? = null

    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 123 && resultCode == Activity.RESULT_OK) {
            exibeFoto()
        }
    }


    private fun exibeFoto() {


        val bitmap = BitmapFactory.decodeFile(caminho)

        val scaledBitmap =
            Bitmap.createScaledBitmap(bitmap, 300, 300, true)


        foto.scaleType = ImageView.ScaleType.FIT_XY
        foto.setImageBitmap(scaledBitmap)

        val base64 = scaledBitmap.toBase64()

        foto.tag = base64


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.formulario_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.menuSalvar -> {
                publicaTweet()
                finish()
            }

            R.id.menuFoto -> {

                tiraFoto()
            }

            android.R.id.home -> finish()
        }

        return true

    }

    private fun tiraFoto() {
        val vaiParaCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        vaiParaCamera.putExtra(MediaStore.EXTRA_OUTPUT, caminhoFoto())

        startActivityForResult(vaiParaCamera, 123)
    }

    private fun caminhoFoto(): Uri {

        caminho = "${getExternalFilesDir("imagens")}/${System.currentTimeMillis()}.jpg"

        val arquivo = File(caminho)

        return FileProvider.getUriForFile(this, "MeuProvider", arquivo)

    }

    private fun publicaTweet() {
        val texto = campoDeMensagem.text.toString()

        val base64 = foto.tag as String?

        val tweet = Tweet(texto, base64)

        viewModel.publicaTweet(tweet)

        Toast.makeText(this, "$tweet", Toast.LENGTH_LONG).show()
    }
}
