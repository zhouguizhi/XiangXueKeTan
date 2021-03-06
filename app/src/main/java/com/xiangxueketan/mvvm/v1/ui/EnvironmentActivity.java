package com.xiangxueketan.mvvm.v1.ui;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import com.xiangxueketan.R;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/1/23 下午6:52
 * @Version: 1.0
 */
public class EnvironmentActivity extends AppCompatActivity {
    public static final String NETWORK_ENVIRONMENT_PREF_KEY = "network_environment_type";
    private static String sCurrentNetworkEnvironment = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);
        //setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new MyPreferenceFragment())
                .commit();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        sCurrentNetworkEnvironment = prefs.getString(EnvironmentActivity.NETWORK_ENVIRONMENT_PREF_KEY, "1");
    }

    public static class MyPreferenceFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener, androidx.preference.Preference.OnPreferenceChangeListener {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            addPreferencesFromResource(R.xml.environment_preference);
            findPreference(NETWORK_ENVIRONMENT_PREF_KEY).setOnPreferenceChangeListener(this);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object o) {
            if (!sCurrentNetworkEnvironment.equalsIgnoreCase(String.valueOf(o))) {
                Toast.makeText(getContext(), "您已经更改了网络环境，再您退出当前页面的时候APP将会重启切换环境！", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        @Override
        public boolean onPreferenceChange(androidx.preference.Preference preference, Object newValue) {
            if (!sCurrentNetworkEnvironment.equalsIgnoreCase(String.valueOf(newValue))) {
                Toast.makeText(getContext(), "您已经更改了网络环境，再您退出当前页面的时候APP将会重启切换环境！", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String newValue = prefs.getString(EnvironmentActivity.NETWORK_ENVIRONMENT_PREF_KEY, "1");
        if (!sCurrentNetworkEnvironment.equalsIgnoreCase(newValue)) {
            android.os.Process.killProcess(android.os.Process.myPid());
        } else {
            finish();
        }
    }

    public static boolean isOfficialEnvironment(Application application) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(application);
        String environment = prefs.getString(EnvironmentActivity.NETWORK_ENVIRONMENT_PREF_KEY, "1");
        return "1".equalsIgnoreCase(environment);
    }
}
