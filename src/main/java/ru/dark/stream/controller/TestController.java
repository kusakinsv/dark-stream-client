package ru.dark.stream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test")
public class TestController {


//    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
//    public String index(Model model) {
//        model.addAttribute("playlist", playlist);
//        return "index";
//    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
//    @RequestMapping @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "Сергей");
        return "test";
    }
}

//    @RequestMapping(value = {"/s"}, method = RequestMethod.GET)
//    ResponseEntity list() throws TemplateException, IOException {
//        playlist.clear();
//        final String fileTemplate = "search.ftl";
////        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
//        final Template template = configuration.getTemplate(fileTemplate);
//        Map<String, Object> root = new HashMap<>();
//        root.put("playlist", playlist);
//        Writer out = new StringWriter();
//        template.process(root, out);
//        return new ResponseEntity<String>(out.toString(), responseHeaders, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = {"/r"}, method = RequestMethod.GET)
//    public String redirect(HttpServletResponse response) throws TemplateException, IOException {
//        playlist.clear();
////        final String fileTemplate = "search.ftl";
////        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
////        final Template template = configuration.getTemplate(fileTemplate);
////        Map<String, Object> root = new HashMap<>();
////        root.put("playlist", playlist);
////        Writer out = new StringWriter();
////        template.process(root, out);
////        String redirectPath = "google.ru";
////        response.sendRedirect(redirectPath);
//        File file = new File("C:\\Coding\\Java\\Projects\\dark-stream\\dark-stream-client\\src\\main\\resources\\static\\index.html");
//        String s = new FileReader(file).toString();
//        return s;
//    }
//
//
//    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
//    public ResponseEntity searchParams(@RequestParam(value = "trackname", required = false) String trackname) throws IOException, TemplateException {
////        if (inProgress) return ResponseEntity.ok(new HashMap<String, String>() {{
////            put("system", "previous request in progress");
////        }});
////        inProgress = true;
//        playlist.clear();
//        final String fileTemplate = "search.ftl";
////        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
//        Template template = configuration.getTemplate(fileTemplate);
//        Map<String, Object> hashMap = new HashMap<>();
//        InternetMusicSercher musicSercher = new InternetMusicSercher();
//        playlist.addAll(musicSercher.searchMusic(trackname));
//        List<MusicTrack> sublist = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            sublist.add(playlist.get(i));
//        }
//        hashMap.put("playlist", sublist);
////        Writer out = new StringWriter();
//        File file = File.createTempFile(UUID.randomUUID().toString(), ".html");
//        File file2 = new File(UUID.randomUUID().toString(), ".html");
//        Writer out = new FileWriter(file);
//        template.process(hashMap, out);
//        out.flush();
//
//        if (trackname == null) {
//            return ResponseEntity.ok(new HashMap<String, String>() {{
//                put("system", "no parameters");
//            }});
//        }
//        System.out.println(file.getAbsolutePath());
////        playlist.forEach(x -> System.out.println(x.getUrl()));
//        return new ResponseEntity<File>(file, responseHeadersS, HttpStatus.OK);
////        return ResponseEntity.ok(out.toString());
//    }


//    @RequestMapping(value = {"/s"}, method = RequestMethod.GET)
//    ResponseEntity list() throws TemplateException, IOException {
//        playlist.clear();
//        final String fileTemplate = "search.ftl";
////        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
//        final Template template = configuration.getTemplate(fileTemplate);
//        Map<String, Object> root = new HashMap<>();
//        root.put("playlist", playlist);
//        Writer out = new StringWriter();
//        template.process(root, out);
//        return new ResponseEntity<String>(out.toString(), responseHeaders, HttpStatus.OK);
//    }

//    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
//    public ResponseEntity searchParams(@RequestParam(value = "trackname", required = false) String trackname) throws IOException, TemplateException {
////        if (inProgress) return ResponseEntity.ok(new HashMap<String, String>() {{
////            put("system", "previous request in progress");
////        }});
////        inProgress = true;
//        playlist.clear();
//        final String fileTemplate = "search.ftl";
////        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
//        Template template = configuration.getTemplate(fileTemplate);
//        Map<String, Object> root = new HashMap<>();
//        InternetMusicSercher musicSercher = new InternetMusicSercher();
//        playlist.addAll(musicSercher.searchMusic(trackname));
//        List<MusicTrack> sublist= new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            sublist.add(playlist.get(i));
//        }
//        root.put("playlist", sublist);
////        Writer out = new StringWriter();
//        File file = File.createTempFile(UUID.randomUUID().toString(), ".html");
//        File file2 = new File(UUID.randomUUID().toString(), ".html");
//        Writer out = new FileWriter(file);
//        template.process(root, out);
//        out.flush();
//
//        if (trackname == null) {
//            return ResponseEntity.ok(new HashMap<String, String>() {{
//                put("system", "no parameters");
//            }});
//        }
//        System.out.println(file.getAbsolutePath());
////        playlist.forEach(x -> System.out.println(x.getUrl()));
//        return new ResponseEntity<>(out, responseHeaders, HttpStatus.OK);
////        return ResponseEntity.ok(out.toString());
//}

//    @GetMapping("/searchPage")
//    String searchPage() throws TemplateException, IOException {
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
//        final String fileTemplate = "serchMusic.ftl";
//        final Template template = FreemakerConfigUtil.getConfiguration().getTemplate(fileTemplate);
//        Map<String, Object> root = new HashMap<>();
//        root.put("name", "Sergei");
//        Writer out = new StringWriter();
//        template.process(root, out);
//        return out.toString();
//    }
