package com.wbj.designpatter.builder;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 下午2:53
 * 描述：
 */
public class DialogDemo {

    private String title;
    private String content;

    private DialogDemo(Builder builder) {
        this.title = builder.title;
        this.content = builder.content;
    }

    public void show(){
        System.out.println("title:" + title + "content:" + content);
    }

    public static class Builder{
        private String title;
        private String content;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public DialogDemo build(){
            return new DialogDemo(this);
        }
    }
}
