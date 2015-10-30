# 本代码是androidstudio编写，其中也有eclipse版本在对应的eclipse文件夹里

##效果
 ![image](https://github.com/dalong982242260/UrlToOpenApp/blob/master/screenshot/urlopenapp.gif)       
   
   
##功能
1、通过intent启动app并传值
2、通过url可以自动启动app。
3、可以通过点击短信，qq，各种浏览器加载指定的url都可以启动app并传值。



##通过intent启动并传值

                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.dalong.app2",
                        "com.dalong.app2.MainActivity"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name", "lisi");
                intent.putExtra("age", "18");
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
                
                

                
##通过scheme启动并传值  
             
              <intent-filter>
                       <action android:name="android.intent.action.VIEW"/>
                       <category android:name="android.intent.category.DEFAULT" />
                       <category android:name="android.intent.category.BROWSABLE" />
                       <data android:scheme="dalong" android:host="my.app" android:pathPrefix="/openwith"/>
              </intent-filter>
              
##通过intent和scheme启动获取数据值
              
                      Intent intent=getIntent();
                      String name="";
                      String age="";
                      if(intent!=null){
                          /**************通过intent启动*******************/
                          name=intent.getStringExtra("name");
                          age=intent.getStringExtra("age");
                          String action = intent.getAction();
              
                          /**************通过scheme 启动*******************/
                          if(Intent.ACTION_VIEW.equals(action)){
                              Uri uri = intent.getData();
                              if(uri != null){
                                   name = uri.getQueryParameter("name");
                                   age= uri.getQueryParameter("age");
                              }
                          }
                          textView.setText(name+"\n"+age);
                      }
