package mk.ukim.finki.wp.lms.wpproject;

import mk.ukim.finki.wp.lms.wpproject.Model.Book;
import mk.ukim.finki.wp.lms.wpproject.Model.Category;
import mk.ukim.finki.wp.lms.wpproject.Model.Member;
import mk.ukim.finki.wp.lms.wpproject.Model.User;
import mk.ukim.finki.wp.lms.wpproject.Service.BookService;
import mk.ukim.finki.wp.lms.wpproject.Service.CategoryService;
import mk.ukim.finki.wp.lms.wpproject.Service.MemberService;
import mk.ukim.finki.wp.lms.wpproject.Service.UserService;
import mk.ukim.finki.wp.lms.wpproject.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        initDatabaseEntities();
    }


    private void initDatabaseEntities() {

        categoryService.addNew(new Category("Operating systems", "OS", "Books on operating systems", new Date()));
        categoryService.addNew(new Category("Computer programming", "CP", "Computer programming books", new Date()));
        categoryService.addNew(new Category("Software engineering", "SE", "Software engineering books", new Date()));

        bookService.addNew(new Book("The Art of Computer Programming", "CP-TAOCP", "Donald Knuth", "Addison-Wesley", "0-201-03801-3", categoryService.get(1L)));
        bookService.addNew(new Book("The Pragmatic Programmer", "CP-TPP", "Andy Hunt, Dave Thomas", "Addison-Wesley", "978-0201616224", categoryService.get(1L)));
        bookService.addNew(new Book("Modern Operating Systems", "OS-MOS", "Andrew S. Tanenbaum", "Prentice Hall", "978-0133591620", categoryService.get(2L)));
        bookService.addNew(new Book("Operating Systems: Internals and Design Principles", "OS-IDP", "William Stallings", "Pearson", "978-0133805918", categoryService.get(2L)));
        bookService.addNew(new Book("Code Complete: A Practical Handbook of Software Construction", "SE-CC", "Steve McConnell", "Microsoft Press", "978-0-7356-1967-8", categoryService.get(3L)));
        bookService.addNew(new Book("Refactoring: Improving the Design of Existing Code", "SE-R", "Martin Fowler, Kent Beck", "Erich Gamma", "978-0201485677", categoryService.get(3L)));

        memberService.addNew(new Member(Constants.MEMBER_STUDENT, "Stefan", "Gjurcheski", "Male", new Date(1997, 7, 31), "078888888", "mail@mail.com"));

        if( userService.getAllUsers().size() == 0) {
            userService.addNew(new User("Mr. Admin", "admin", "admin", Constants.ROLE_ADMIN));
            userService.addNew(new User("Mr. Librarian", "librarian", "librarian", Constants.ROLE_LIBRARIAN));
        }

    }
}