package quartz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quartz.listeners.QuartzListener;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
@WebServlet("/edit")
public class EditTriggerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            ServletContext ctx = req.getServletContext();
            StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QuartzListener.QUARTZ_FACTORY_KEY);
            Scheduler scheduler = factory.getScheduler();
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(new TriggerKey("simple"));
            out.println("<form action=edit method=post>");
            out.printf("Expresi\u00f3n Cron: <input type=text name=exp value=\"%s\" required>",
                    trigger.getCronExpression());
            out.println("<button>Enviar</button>");
            out.println("</form>");
        } catch (Exception e) {
            out.print("<pre>");
            e.printStackTrace(out);
            out.print("</pre>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            String cronExpression = req.getParameter("exp");
            ServletContext ctx = req.getServletContext();
            StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QuartzListener.QUARTZ_FACTORY_KEY);
            Scheduler scheduler = factory.getScheduler();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simple").withSchedule(
                    CronScheduleBuilder.cronSchedule(cronExpression)).startNow().build();
            Date date = scheduler.rescheduleJob(new TriggerKey("simple"), trigger);
            out.printf(new Locale("es", "MX"), "Trabajo re-calendarizado<br>Próxima ejecución:<br>%tc", date);
        } catch (Exception e) {
            out.print("<pre>");
            e.printStackTrace(out);
            out.print("</pre>");
        }
    }
}