function test(keyword,event){    
          
        //定义全局变量    
        var keyword = $("#search_input").val();     
        var sel = document.getElementById("sel");   
        var regExp = new RegExp(keyword, "g");//创建正则表达式，g表示全局的，如果不用g，则查找到第一个就不会继续向下查找了；  
        $.getJSON(         
                "/user/index1/select",//url    
                "keyword="+ keyword,//发送的数据    
                function(data){//获取响应回来的数据    
                    document.getElementById("sel").innerHTML="";    
                   /* var arr = new Array;   
                    var arr = data.split("#");//将响应回来的数据按#拆分成数组            
                       
                    for(var i=0;i<arr.length;i++){//循环每一个满足条件的记录   
                        //将当前循环满足条件的商品名称生成一个下拉的选项   
                        sel.options[i]=new Option(arr[i],i);   
                    }  */  
                    for(var i=0;i<data.length;i++){  
                         //将当前循环满足条件的商品名称生成一个下拉的选项    
                        sel.options[i]=new Option(data[i].blogTitle,i);  
                          
                    }  
                    //自动设置高度  
                   sel.size=data.length;  
                    //判断是否有满足条件的商品    
                    if(data.length>0){    
                        sel.style.display='block';    
                    }else{    
                        sel.style.display='none';    
                    }    
                    //当用户按下上下键时获取相应的值    
                    if(event.keyCode==40){    
                        sel.focus();    
                    }       
                    //搜索到的关键字加粗  
                    $("#sel option").each(function()//遍历文章；  
                            {  //遍历所有option    
                                  var txt = $(this).html();   //获取option值   
                                  var newHtml = txt.replace(regExp, "<strong style='color:black'>"+keyword+"</strong>");//将找到的关键字替换，加上highlight属性；  
                                  $(this).html(newHtml);//更新文章；  
                        });  
                    });   
};  
        
 function test2(){    
        //输入回车，获取输入框内容焦点    
       /* $("#sel").keypress(function(){   
                $("#search_input").focus();   
                $("#sel").css("display","none");   
        }); */   
         //双击，获取输入框内容焦点    
         $("#sel").click(function(){    
             $("#search_input").focus();    
             $("#sel").css("display","none");  
            /* var keyword=$("#search_input").val(); 
             location.href="/blog/user/search?searchid="+keyword;*/  
         });    
         //将选中的下拉列表中的内容添加到输入框中    
        $("#search_input").val($("option:selected").text());  
          
    }     