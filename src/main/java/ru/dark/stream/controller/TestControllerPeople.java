//package ru.dark.stream.controller;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ru.dark.stream.model.MusicTrack;
//import ru.dark.stream.model.Person;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class TestControllerPeople {
//
//    private static HttpHeaders responseHeaders = new HttpHeaders();
//
//
//    private static List<MusicTrack> playlist = new ArrayList<>();
//
//    static {
//        responseHeaders.add("Content-Type", "text/html; charset=utf-8");
////        playlist.add(new MusicTrack("Группа Крови", "Кино", "www.google.ru", "04:44", "Группа крови"));
////        playlist.add(new MusicTrack("Красно-желтые дни", "в.Цой", "www.google.ru", "04:44", "красно-желтые дни"));
//    }
//
//
//    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
//    public String index(Model model) throws IOException {
//        Person single = new Person("Первый", 11);
//        List<Person> people = new ArrayList<>();
//
//        Person p1 = new Person("Сергей", 32);
//        Person p2 = new Person("Иван", 27);
//        Person p3 = new Person("Дмитрий", 18);
//        people.add(p1);
//        people.add(p2);
//        people.add(p3);
//        String audiostring = "C:\\Coding\\Java\\Projects\\dark-stream\\dark-stream-client\\music\\Nikto.mp3";
//        model.addAttribute("singlePerson", single);
//        model.addAttribute("people", people);
//        model.addAttribute("audio", audiostring);
////        model.addAttribute("audio",audiostring);
//        return "index";
//    }
//
////    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
////    public String test() {
////        return new String("allright");
////    }
//
////    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
////    public ResponseEntity searchParams(@RequestParam(value = "trackname", required = false) String trackname) throws IOException, TemplateException {
//////        if (inProgress) return ResponseEntity.ok(new HashMap<String, String>() {{
//////            put("system", "previous request in progress");
//////        }});
//////        inProgress = true;
////        playlist.clear();
////        final String fileTemplate = "search.ftl";
//////        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
////        Template template = configuration.getTemplate(fileTemplate);
////        Map<String, Object> root = new HashMap<>();
////        InternetMusicSercher musicSercher = new InternetMusicSercher();
////        playlist.addAll(musicSercher.searchMusic(trackname));
////        List<MusicTrack> sublist= new ArrayList<>();
////        for (int i = 0; i < 10; i++) {
////            sublist.add(playlist.get(i));
////        }
////        root.put("playlist", sublist);
//////        Writer out = new StringWriter();
////        File file = File.createTempFile(UUID.randomUUID().toString(), ".html");
////        File file2 = new File(UUID.randomUUID().toString(), ".html");
////        Writer out = new FileWriter(file);
////        template.process(root, out);
////        out.flush();
////
////        if (trackname == null) {
////            return ResponseEntity.ok(new HashMap<String, String>() {{
////                put("system", "no parameters");
////            }});
////        }
////        System.out.println(file.getAbsolutePath());
//////        playlist.forEach(x -> System.out.println(x.getUrl()));
////        return new ResponseEntity<>(out, responseHeaders, HttpStatus.OK);
//////        return ResponseEntity.ok(out.toString());
////    }
//
//
////    @RequestMapping(value = {"/s"}, method = RequestMethod.GET)
////    ResponseEntity list() throws TemplateException, IOException {
////        playlist.clear();
////        final String fileTemplate = "search.ftl";
//////        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
////        final Template template = configuration.getTemplate(fileTemplate);
////        Map<String, Object> root = new HashMap<>();
////        root.put("playlist", playlist);
////        Writer out = new StringWriter();
////        template.process(root, out);
////        return new ResponseEntity<String>(out.toString(), responseHeaders, HttpStatus.OK);
////    }
//
////    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
////    public ResponseEntity searchParams(@RequestParam(value = "trackname", required = false) String trackname) throws IOException, TemplateException {
//////        if (inProgress) return ResponseEntity.ok(new HashMap<String, String>() {{
//////            put("system", "previous request in progress");
//////        }});
//////        inProgress = true;
////        playlist.clear();
////        final String fileTemplate = "search.ftl";
//////        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
////        Template template = configuration.getTemplate(fileTemplate);
////        Map<String, Object> root = new HashMap<>();
////        InternetMusicSercher musicSercher = new InternetMusicSercher();
////        playlist.addAll(musicSercher.searchMusic(trackname));
////        List<MusicTrack> sublist= new ArrayList<>();
////        for (int i = 0; i < 10; i++) {
////            sublist.add(playlist.get(i));
////        }
////        root.put("playlist", sublist);
//////        Writer out = new StringWriter();
////        File file = File.createTempFile(UUID.randomUUID().toString(), ".html");
////        File file2 = new File(UUID.randomUUID().toString(), ".html");
////        Writer out = new FileWriter(file);
////        template.process(root, out);
////        out.flush();
////
////        if (trackname == null) {
////            return ResponseEntity.ok(new HashMap<String, String>() {{
////                put("system", "no parameters");
////            }});
////        }
////        System.out.println(file.getAbsolutePath());
//////        playlist.forEach(x -> System.out.println(x.getUrl()));
////        return new ResponseEntity<>(out, responseHeaders, HttpStatus.OK);
//////        return ResponseEntity.ok(out.toString());
////}
//
////    @GetMapping("/searchPage")
////    String searchPage() throws TemplateException, IOException {
////        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
////        final String fileTemplate = "serchMusic.ftl";
////        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
////        Map<String, Object> root = new HashMap<>();
////        root.put("name", "Sergei");
////        Writer out = new StringWriter();
////        template.process(root, out);
////        return out.toString();
////    }
//
//
//}
