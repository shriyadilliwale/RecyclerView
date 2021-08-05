package com.example.camera

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ImageAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager= layoutManager

        adapter= ImageAdapter()
        recyclerView.adapter= adapter
    }
}
//    var imageview: ImageView? = null
//    var btn: Button? = null
//    var cancel: ImageButton? = null
//    private val SELECT_FROM_GALLERY = 0
//    private val REQUEST_CAMERA = 1
//    var currentPhotoPath: String? = null
//    var recyclerView: RecyclerView? = null
//    var mLayoutManager: RecyclerView.LayoutManager? = null
//    var imageAdapter: ImageAdapter? = null
//    var image: ArrayList<String?> = ArrayList()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        btn = findViewById<View>(R.id.btn) as Button
//        recyclerView = findViewById(R.id.rv_image)
//        cancel = findViewById<View>(R.id.cancel) as ImageButton
//        btn!!.setOnClickListener(this)
//    }
//
//    @RequiresApi(Build.VERSION_CODES.N)
//    fun ImageChooser() {
//        val items =
//            arrayOf<CharSequence>("Take Photo", "Choose from library", "Cancel")
//        val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
//        builder.setItems(items, DialogInterface.OnClickListener { dialog, item ->
//            if (items[item] == "Take Photo") {
//                CamaraIntent()
//            } else if (items[item] == "Choose from library") {
//                GalleryIntent()
//            } else if (items[item] == "Cancel") {
//                dialog.dismiss()
//            }
//        })
//        builder.show()
//    }
//
//    @RequiresApi(Build.VERSION_CODES.N)
//    fun CamaraIntent() {
//        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        if (intent.resolveActivity(packageManager) != null);
//        run {
//            var photoFile: File? = null
//            try {
//                photoFile = createImageFile()
//            } catch (e: Exception) {
//            }
//            if (photoFile != null) {
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile))
//                startActivityForResult(
//                    Intent.createChooser(intent, "Select Camara"),
//                    REQUEST_CAMERA
//                )
//            }
//        }
//    }


//    val REQUEST_CODE = 200
//
//    private fun openGalleryForImages() {
//
//        if (Build.VERSION.SDK_INT < 19) {
//            var intent = Intent()
//            intent.type = "image/*"
//            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
//            intent.action = Intent.ACTION_GET_CONTENT
//            startActivityForResult(
//                Intent.createChooser(intent, "Choose Pictures")
//                , REQUEST_CODE
//            )
//        }
//        else { // For latest versions API LEVEL 19+
//            var intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
//            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
//            intent.addCategory(Intent.CATEGORY_OPENABLE)
//            intent.type = "image/*"
//            startActivityForResult(intent, REQUEST_CODE);
//        }
//
//    }

//    @RequiresApi(Build.VERSION_CODES.N)
//    @Throws(IOException::class)
//    fun createImageFile(): File {
//        val timeStamp =
//            SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//        val imageFileName = "JPEG_" + timeStamp + "_"
//        val storageDir =
//            getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//        val image = File.createTempFile(
//            imageFileName,  /* prefix */
//            ".jpg",  /* suffix */
//            storageDir /* directory */
//        )
//        currentPhotoPath = image.absolutePath
//        return image
//    }
//
//    fun GalleryIntent() {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_FROM_GALLERY)
//    }

//    @RequiresApi(Build.VERSION_CODES.N)
//    override fun onClick(v: View) {
//        if (checkPermission()) {
//            if (camaraCheckPermission()) {
//                ImageChooser()
//            } else {
//                camaraRequestPermission()
//            }
//        } else {
//            requestPermission()
//        }
//    }
//
//    public override fun onActivityResult(
//        requestCode: Int,
//        resultCode: Int,
//        data: Intent?
//    ) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK) {
//            if (resultCode == Activity.RESULT_OK) {
//                var path: String? = null
//                if (requestCode == SELECT_FROM_GALLERY) {
//                    path = data!!.data.toString()
//                } else if (requestCode == REQUEST_CAMERA) {
//                    path = "file://$currentPhotoPath"
//                }
//                if (path != null) Log.d("IMAGE URI :", path)
//                //                imageview.setImageURI(Uri.parse(path));
////                 startActivity(new Intent(this, ImageAdapter.class).putExtra("uriImage", path));
//                image.add(path)
//                loadingimagedata()
//            }
//        }
//    }
//
//
//
//   //extra
//    override fun onActivityResult1(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
//
//            // if multiple images are selected
//            if (data?.getClipData() != null) {
//                var count = data.clipData?.itemCount
//
//                if (count != null) {
//                    for (i in 0..count - 1) {
//                        var imageUri: Uri = data.clipData?.getItemAt(i)!!.uri
//                        //     iv_image.setImageURI(imageUri) Here you can assign your Image URI to the ImageViews
//                    }
//                }
//
//            } else if (data?.getData() != null) {
//                // if single image is selected
//
//                var imageUri: Uri = data.data!!
//
//
//                //   iv_image.setImageURI(imageUri) Here you can assign the picked image uri to your imageview
//                 }
//        }
//    }
//
//    private fun loadingimagedata() {
////        if (image.size() > 0) {
//        mLayoutManager =
//            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView!!.layoutManager = mLayoutManager
//        recyclerView!!.adapter = imageAdapter
//        imageAdapter=ImageAdapter(this,image)
//
//        //     var image: ArrayList<String?> = ArrayList()   var imageAdapter: ImageAdapter? = null   var mLayoutManager: RecyclerView.LayoutManager? = null}
//    }
//
//    private fun requestPermission() {
//        ActivityCompat.requestPermissions(
//            this@MainActivity,
//            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
//            RequestPermissionCode
//        )
//    }
//
//    fun checkPermission(): Boolean {
//        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            val result = ContextCompat.checkSelfPermission(
//                this@MainActivity,
//                Manifest.permission.READ_EXTERNAL_STORAGE
//            )
//            result == PackageManager.PERMISSION_GRANTED
//        } else {
//            true
//        }
//    }
//
//    private fun camaraRequestPermission() {
//        ActivityCompat.requestPermissions(
//            this@MainActivity,
//            arrayOf(Manifest.permission.CAMERA),
//            cameraRequestPermissionCode
//        )
//    }
//
//    fun camaraCheckPermission(): Boolean {
//        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            val result =
//                ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA)
//            result == PackageManager.PERMISSION_GRANTED
//        } else {
//            true
//        }
//    }
//
//    companion object {
//        const val RequestPermissionCode = 1
//        const val cameraRequestPermissionCode = 2
//    }
//}