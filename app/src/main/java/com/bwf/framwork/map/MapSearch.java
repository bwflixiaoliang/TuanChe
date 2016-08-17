//package com.bwf.framwork.map;
//
//import com.baidu.mapapi.map.BaiduMap;
//import com.baidu.mapapi.map.BitmapDescriptor;
//import com.baidu.mapapi.map.BitmapDescriptorFactory;
//import com.baidu.mapapi.map.MapStatus;
//import com.baidu.mapapi.map.MapStatusUpdate;
//import com.baidu.mapapi.map.MapStatusUpdateFactory;
//import com.baidu.mapapi.map.MapView;
//import com.baidu.mapapi.map.Marker;
//import com.baidu.mapapi.map.MarkerOptions;
//import com.baidu.mapapi.map.OverlayOptions;
//import com.baidu.mapapi.model.LatLng;
//import com.buyimingyue.myintroduction.R;
//
///**
// * Created by lixiaoliang on 2016/8/11.
// * Description:
// */
//public class MapSearch {
//   private BaiduMap mBaiduMap =null;
//    private  Marker marker;
//    public MapSearch(MapView mMapView) {
//        mBaiduMap = mMapView.getMap();
//    }
//    public void changeMapStaus(float latitude,float longitude){
//        LatLng latLng = new LatLng(latitude,longitude);
//        MapStatus mapStatus = new MapStatus.Builder().target(latLng).zoom(12).build();
//        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
//        mBaiduMap.setMapStatus(mapStatusUpdate);
//    }
//   public void getNormalMap(){
//       //普通地图
//       mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
//   }
//   public void getStarMap(){
//       //卫星地图
//       mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
//   }
//   public void getBlankMap(){
//       //空白地图, 基础地图瓦片将不会被渲染。在地图类型中设置为NONE，将不会使用流量下载基础地图瓦片图层。使用场景：与瓦片图层一起使用，节省流量，提升自定义瓦片图下载速度。
//       mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
//   }
//   public void isTrafficMap(boolean b){
//       //开启交通图
//       mBaiduMap.setTrafficEnabled(b);
//   }
//    public void isHeatMap(boolean b){
//        //开启城市热力图
//        mBaiduMap.setBaiduHeatMapEnabled(b);
//    }
//    /*
//    * 地图Logo
//    默认在左下角显示，不可以移除。
//    通过mMapView.setLogoPosition(LogoPosition.logoPostionleftBottom);方法，使用枚举类型控制显示的位置，共支持6个显示位置(左下，中下，右下，左上，中上，右上)。
//    地图Logo不允许遮挡，可通过mBaiduMap.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);方法可以设置地图边界区域，来避免UI遮挡。
//    其中参数paddingLeft、paddingTop、paddingRight、paddingBottom参数表示距离屏幕边框的左、上、右、下边距的距离，单位为屏幕坐标的像素密度。
//    指南针
//    指南针默认为开启状态，可以关闭显示 。
//    比例尺
//    比例尺默认为开启状态，可以关闭显示。同时支持设置MaxZoomLevel和minZoomLevel，可通过mMapView.getMapLevel获取当前地图级别下比例尺所表示的距离大小
//*/
//    public void setMarkerPoint(float latitude,float longitude){
//        //定义Maker坐标点
//        LatLng point = new LatLng(latitude, longitude);
//        //构建Marker图标
//        BitmapDescriptor bitmap = BitmapDescriptorFactory
//                .fromResource(R.drawable.icon_marka);
//        //构建MarkerOption，用于在地图上添加Marker
//        OverlayOptions option = new MarkerOptions()
//                .position(point)
//                .icon(bitmap);
//        //在地图上添加Marker，并显示
//        mBaiduMap.addOverlay(option);
//    }
//    //
//    public void setCanDragMarkerPoint(float latitude,float longitude){
//        LatLng point = new LatLng(latitude, longitude);
//        //构建Marker图标
//        BitmapDescriptor bitmap = BitmapDescriptorFactory
//                .fromResource(R.drawable.icon_marka);
//        //构建MarkerOption，用于在地图上添加Marker
//        OverlayOptions options = new MarkerOptions()
//                .position(point)  //设置marker的位置
//                .icon(bitmap)  //设置marker图标
//                .zIndex(9)  //设置marker所在层级
//                .draggable(true);  //设置手势拖拽
//        //将marker添加到地图上
//        marker = (Marker) (mBaiduMap.addOverlay(options));
//        mBaiduMap.setOnMarkerDragListener(new BaiduMap.OnMarkerDragListener() {
//            public void onMarkerDrag(Marker marker) {
//                //拖拽中
//            }
//            public void onMarkerDragEnd(Marker marker) {
//                //拖拽结束
//            }
//            public void onMarkerDragStart(Marker marker) {
//                //开始拖拽
//            }
//        });
//    }
//}
