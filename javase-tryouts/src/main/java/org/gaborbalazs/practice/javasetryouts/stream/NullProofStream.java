package org.gaborbalazs.practice.javasetryouts.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class NullProofStream {

    public static void main(String[] args) {

        System.out.println(">> main()");

        NullProofStream app = new NullProofStream();

        List<Bundle> list = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.setNumber(10d);
        list.add(bundle);

        Double number = app.getNumber(list);

        System.out.println(number);

        System.out.println("<< main()");

    }

    public double getNumber(List<Bundle> list) {
        return Optional
                .ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .findFirst()
                .orElseGet(() -> {
                    Bundle bundle = new Bundle();
                    bundle.setNumber(0d);
                    return bundle;
                })
                .getNumber();
    }
}

class Bundle {

    private Double number;

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }
}