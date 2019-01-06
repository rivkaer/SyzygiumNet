package com.rivkaer.moonnet.template;

/**
 * Create by JJ Jia on 2018/6/17
 *
 * function: Json Unified outer stripping Base Bean
 */
public class BaseBean<T> {


    /**
     * error : false
     * results : [{"_id":"5c2dabdb9d21226e068debf9","createdAt":"2019-01-03T06:29:47.895Z","desc":"2019-01-03","publishedAt":"2019-01-03T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg","used":true,"who":"lijinshanmx"},{"_id":"5c25db189d21221e8ada8664","createdAt":"2018-12-28T08:13:12.688Z","desc":"2018-12-28","publishedAt":"2018-12-28T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg","used":true,"who":"lijinshanmx"},{"_id":"5c12216d9d21223f5a2baea2","createdAt":"2018-12-13T09:07:57.2Z","desc":"2018-12-13","publishedAt":"2018-12-13T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bfe1a5b9d2122309624cbb7","createdAt":"2018-11-28T04:32:27.338Z","desc":"2018-11-28","publishedAt":"2018-11-28T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bf22fd69d21223ddba8ca25","createdAt":"2018-11-19T03:36:54.950Z","desc":"2018-11-19","publishedAt":"2018-11-19T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg","used":true,"who":"lijinshanmx"},{"_id":"5be14edb9d21223dd50660f8","createdAt":"2018-11-06T08:20:43.656Z","desc":"2018-11-06","publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwyf0wr8hhj30ie0nhq6p.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bcd71979d21220315c663fc","createdAt":"2018-10-22T06:43:35.440Z","desc":"2018-10-22","publishedAt":"2018-10-22T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bc434ac9d212279160c4c9e","createdAt":"2018-10-15T06:33:16.497Z","desc":"2018-10-15","publishedAt":"2018-10-15T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fw8wzdua6rj30sg0yc7gp.jpg","used":true,"who":"lijinshanmx"},{"_id":"5bbb0de09d21226111b86f1c","createdAt":"2018-10-08T07:57:20.978Z","desc":"2018-10-08","publishedAt":"2018-10-08T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fw0vdlg6xcj30j60mzdk7.jpg","used":true,"who":"lijinshanmx"},{"_id":"5ba206ec9d2122610aba3440","createdAt":"2018-09-19T08:21:00.295Z","desc":"2018-09-19","publishedAt":"2018-09-19T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fvexaq313uj30qo0wldr4.jpg","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
