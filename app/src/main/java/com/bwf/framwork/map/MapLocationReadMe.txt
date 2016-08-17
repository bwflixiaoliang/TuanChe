使用综合定位功能
综合定位功能指的根据用户实际需求，返回用户当前位置的基础定位服务。包含GPS和网络定位（Wi-Fi和基站定位）功能。基本定位功能同时还支持结合定位结果的反地理编码功能，离线定位，位置提醒功能和位置语义化功能。
第一步，初始化LocationClient类

此处需要注意：LocationClient类必须在主线程中声明。需要Context类型的参数。

Context需要时全进程有效的context,推荐用getApplicationConext获取全进程有效的context

public LocationClient mLocationClient = null;
public BDLocationListener myListener = new MyLocationListener();

public void onCreate() {
    mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
    mLocationClient.registerLocationListener( myListener );    //注册监听函数
}

LocationClient类是定位SDK的核心类，具体方法详见类参考。
第二步，配置定位SDK参数

设置定位参数包括：定位模式（高精度定位模式，低功耗定位模式和仅用设备定位模式），返回坐标类型，是否打开GPS，是否返回地址信息、位置语义化信息、POI信息等等。

LocationClientOption类，该类用来设置定位SDK的定位方式，e.g.：

private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationMode.Hight_Accuracy
);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

高精度定位模式：这种定位模式下，会同时使用网络定位和GPS定位，优先返回最高精度的定位结果；

低功耗定位模式：这种定位模式下，不会使用GPS，只会使用网络定位（Wi-Fi和基站定位）；

仅用设备定位模式：这种定位模式下，不需要连接网络，只使用GPS进行定位，这种模式下不支持室内环境的定位。
第三步，实现BDLocationListener接口

BDLocationListener接口有1个方法需要实现： 1.接收异步返回的定位结果，参数是BDLocation类型参数。

public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            //Receive Location
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation){// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
sb.append("\nlocationdescribe : ");
                sb.append(location.getLocationDescribe());// 位置语义化信息
                List<Poi> list = location.getPoiList();// POI数据
                if (list != null) {
                    sb.append("\npoilist size = : ");
                    sb.append(list.size());
                    for (Poi p : list) {
                        sb.append("\npoi= : ");
                        sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                    }
                }
            Log.i("BaiduLocationApiDem", sb.toString());
        }

BDLocation类，封装了定位SDK的定位结果，在BDLocationListener的onReceive方法中获取。通过该类用户可以获取error code，位置的坐标，精度半径等信息。具体方法请参考类参考。

获取error code：

public int getLocType ( )

返回值：

61 ： GPS定位结果，GPS定位成功。

62 ： 无法获取有效定位依据，定位失败，请检查运营商网络或者wifi网络是否正常开启，尝试重新请求定位。

63 ： 网络异常，没有成功向服务器发起请求，请确认当前测试手机网络是否通畅，尝试重新请求定位。

65 ： 定位缓存的结果。

66 ： 离线定位结果。通过requestOfflineLocaiton调用时对应的返回结果。

67 ： 离线定位失败。通过requestOfflineLocaiton调用时对应的返回结果。

68 ： 网络连接失败时，查找本地离线定位时对应的返回结果。

161： 网络定位结果，网络定位定位成功。

162： 请求串密文解析失败，一般是由于客户端SO文件加载失败造成，请严格参照开发指南或demo开发，放入对应SO文件。

167： 服务端定位失败，请您检查是否禁用获取位置信息权限，尝试重新请求定位。

502： key参数错误，请按照说明文档重新申请KEY。

505： key不存在或者非法，请按照说明文档重新申请KEY。

601： key服务被开发者自己禁用，请按照说明文档重新申请KEY。

602： key mcode不匹配，您的ak配置过程中安全码设置有问题，请确保：sha1正确，“;”分号是英文状态；且包名是您当前运行应用的包名，请按照说明文档重新申请KEY。

501～700：key验证失败，请按照说明文档重新申请KEY。

如果不能定位，请记住这个返回值，并到百度LBS开放平台论坛Andriod定位SDK版块中进行交流http://bbs.lbsyun.baidu.com/forum.php?mod=forumdisplay&fid=10 。若返回值是162~167，请将错误码、imei和定位时间反馈至loc-bugs@baidu.com，以便我们跟进追查问题。
第四步，开始定位

开启：

mLocationClient.start();

start：启动定位SDK。 stop：关闭定位SDK。调用start之后只需要等待定位结果自动回调即可。

开发者定位场景如果是单次定位的场景，在收到定位结果之后直接调用stop函数即可。

如果stop之后仍然想进行定位，可以再次start等待定位结果回调即可。

如果开发者想按照自己逻辑请求定位，可以在start之后按照自己的逻辑请求locationclient.requestLocation()函数，会主动触发定位SDK内部定位逻辑，等待定位回调即可。
位置提醒使用

位置提醒最多提醒3次，3次过后将不再提醒。 假如需要再次提醒，或者要修改提醒点坐标，都可通过函数SetNotifyLocation()来实现。

//位置提醒相关代码
mNotifyer = new NotifyLister();
mNotifyer.SetNotifyLocation(42.03249652949337,113.3129895882556,3000,"gps");//4个参数代表要位置提醒的点的坐标，具体含义依次为：纬度，经度，距离范围，坐标系类型(gcj02,gps,bd09,bd09ll)
mLocationClient.registerNotify(mNotifyer);
//注册位置提醒监听事件后，可以通过SetNotifyLocation 来修改位置提醒设置，修改后立刻生效。
//BDNotifyListner实现
public class NotifyLister extends BDNotifyListener{
       public void onNotify(BDLocation mlocation, float distance){
 	   mVibrator01.vibrate(1000);//振动提醒已到设定位置附近
       }
    }
//取消位置提醒
mLocationClient.removeNotifyEvent(mNotifyer);