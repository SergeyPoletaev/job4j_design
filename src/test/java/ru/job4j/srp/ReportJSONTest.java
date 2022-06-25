package ru.job4j.srp;

import com.google.gson.Gson;
import org.junit.Test;
import ru.job4j.srp.config.GsonConfigurator;
import ru.job4j.srp.formatter.DateFormatter;
import ru.job4j.srp.formatter.SimpleDateFormatter;
import ru.job4j.srp.model.Employee;
import ru.job4j.srp.report.ReportJSON;
import ru.job4j.srp.store.MemStore;
import ru.job4j.srp.store.Store;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReportJSONTest {

    @Test
    public void generate() {
        Calendar now = Calendar.getInstance();
        Employee emp = new Employee("anna", now, now, 100);
        Employee emp2 = new Employee("sveta", now, now, 200);
        Store store = new MemStore();
        store.add(emp);
        store.add(emp2);
        DateFormatter formatter = new SimpleDateFormatter(new SimpleDateFormat("dd:MM:yyyy"));
        Gson gson = new GsonConfigurator(formatter).get();
        String rsl = new ReportJSON(store, gson).generate(e -> true);
        StringBuilder sb = new StringBuilder();
        String ln = System.lineSeparator();
        sb.append("[").append(ln).append("  ")
                .append("{").append(ln)
                .append("    ").append("\"name\": \"").append(emp.getName()).append("\"").append(",").append(ln)
                .append("    ").append("\"hired\": \"").append(formatter.format(emp.getHired().getTime())).append("\",").append(ln)
                .append("    ").append("\"fired\": \"").append(formatter.format(emp.getFired().getTime())).append("\",").append(ln)
                .append("    ").append("\"salary\": ").append(emp.getSalary()).append(ln)
                .append("  }").append(",").append(ln)
                .append("  {").append(ln)
                .append("    ").append("\"name\": \"").append(emp2.getName()).append("\"").append(",").append(ln)
                .append("    ").append("\"hired\": \"").append(formatter.format(emp2.getHired().getTime())).append("\",").append(ln)
                .append("    ").append("\"fired\": \"").append(formatter.format(emp2.getFired().getTime())).append("\",").append(ln)
                .append("    ").append("\"salary\": ").append(emp2.getSalary()).append(ln)
                .append("  }").append(ln)
                .append("]");
        assertThat(rsl, is(sb.toString()));
    }
}