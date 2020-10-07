package kominfo.go.id.latihanstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;

public class InternalActivity extends AppCompatActivity {
    public static final String FILENAME = "namafile.txt";
    Button buatFile, ubahFile, bacaFile, deleteFile;
    TextView textBaca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        buatFile = findViewById(R.id.buttonBuatFile);
        ubahFile = findViewById(R.id.buttonUbahFile);
        bacaFile = findViewById(R.id.buttonBacaFile);
        deleteFile = findViewById(R.id.buttonHapusFile);
        textBaca = findViewById(R.id.textBaca);

        buatFile.setOnClickListener((View.OnClickListener) this);
        ubahFile.setOnClickListener((View.OnClickListener) this);
        bacaFile.setOnClickListener((View.OnClickListener) this);
        deleteFile.setOnClickListener((View.OnClickListener) this);
    }

    void buatFile(){
        String isiFile = "Coba Isi Data File Text";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file,true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
            }
        catch (Exception e){
            e.printStackTrace();
            }
        }

        void bacaFile(){

        }

        void ubahFile(){

        }

        void deleteFile() {
            File file = new File(getFilesDir(), FILENAME);
            if (file.exists()){
                file.delete();
            }
        }

    public void onCreate(View v){
        jalankanPerintah(v.getId());
    }
    public void jalankanPerintah(int id){
        switch (id){
            case R.id.buttonBuatFile:
                buatFile();
                break;
            case R.id.buttonBacaFile:
                bacaFile();
                break;
            case R.id.buttonUbahFile:
                ubahFile();
                break;
            case R.id.buttonHapusFile:
                deleteFile();
                break;
        }
    }
}