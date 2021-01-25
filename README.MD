面试常问问题：字符串拼接效率问题
            for (int i = 0; i < 10; i++) {
                long start = System.currentTimeMillis();
                StringBuffer str = new StringBuffer();//提升几千倍效率
//                String str = "";
                for (int j = 0; j < 100000; j++) {
                    str.append("a");
                }
                long end = System.currentTimeMillis();

                Log.e("耗时时长"+i,"" + (end - start));
            }
            /*
            * 那StringBuilder中数组的初始长度是多少呢?扩容系数是多少呢?
            数组默认的初始长度是16,也可以根据构造方法指定
            扩容系数: value.length * 2 + 2,而且只有当append是数据长度+value.count > value.length时才会扩容一次,
            * 不会每次都扩容去调用Arrays.copyof()
            * */