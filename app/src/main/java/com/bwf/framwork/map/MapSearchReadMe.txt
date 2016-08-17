Android Studio工程配置方法
第一步：在工程app/libs目录下放入baidumapapi_vX_X_X.jar包，在src/main/目录下新建jniLibs目录，工程会自动加载src目录下的so动态库，放入libBaiduMapSDK_vX_X_X_X.so如下图所示，注意jar和so的前3位版本号必须一致，并且保证使用一次下载的文件夹中的两个文件，不能不同功能组件的jar或so交叉使用。

Androidstudio1.png

so的配置也可以参考demo给出的目录结构，如下图所示，在app工程路径下，新建libs,并在libs目录下放入对应不同CPU架构的so文件。这样工程并不会自动加载libs下的so，需在gradle编译时，通过加入代码： jniLibs.srcDir 'libs' 来说明so的路径为该libs路径。

Androidstudio2.png

第二步：工程配置还需要把jar包集成到自己的工程中，如图上图所示，放入libs目录下。对于每个jar文件，右键-选择Add As Library，导入到工程中。对应在build.gradle生成工程所依赖的jar文件说明，如图所示：

Androidstudio3.png

jar的配置也可参考eclipse方法，进行以下操作：

菜单栏选择 File —>Project Structure。

在弹出的Project Structure 对话框中, 选择module, 然后点击 Dependencies 选项卡.

点击绿色的加号选择File dependency. 然后选择要添加的jar包即可 完成上边的操作后在app目录下的build.gradle文件中，会有引入的类库，如上图所示。

Android studio工程配置详细请参考官方demo。

应用混淆

集成地图SDK的应用，在打包混淆的时候，需要注意与地图SDK相关的方法不可被混淆。混淆方法如下：

-keep class com.baidu.** {*;}
-keep class vi.com.** {*;}
-dontwarn com.baidu.**

保证百度类不能被混淆，否则会出现网络不可用等运行时异常
显示百度地图

百度地图SDK为开发者提供了便捷的显示百度地图数据的接口，通过以下几步操作，即可在您的应用中使用百度地图数据：

第一步：创建并配置工程（具体方法参见工程配置部分的介绍）；

第二步：在AndroidManifest中添加开发密钥、所需权限等信息；

（1）在application中添加开发密钥

<application>
    <meta-data
        android:name="com.baidu.lbsapi.API_KEY"
        android:value="开发者 key" />
</application>

2）添加所需权限

<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="com.android.launcher.permission.READ_SETTINGS" />
<uses-permission android:name="android.permission.WAKE_LOCK"/>
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.GET_TASKS" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.WRITE_SETTINGS" />

第三步，在布局xml文件中添加地图控件；

<com.baidu.mapapi.map.MapView
    android:id="@+id/bmapView"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:clickable="true" />

第四步，在应用程序创建时初始化 SDK引用的Context 全局变量：

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
    }
}

注意：在SDK各功能组件使用之前都需要调用

SDKInitializer.initialize(getApplicationContext());，因此我们建议该方法放在Application的初始化方法中

第五步，创建地图Activity，管理地图生命周期；

public class MainActivity extends Activity {
    MapView mMapView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
        }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
        }
    }