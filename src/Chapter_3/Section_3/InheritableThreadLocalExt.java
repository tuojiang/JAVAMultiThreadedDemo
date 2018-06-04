package Chapter_3.Section_3;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-04-上午11:01
 **/
public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return "sssssssssss";
    }

    @Override
    protected Object childValue(Object o) {
        return o+"子线程～～";
    }
}
