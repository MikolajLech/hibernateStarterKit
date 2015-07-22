package pl.spring.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.spring.demo.service.LibraryService;
import pl.spring.demo.to.LibraryTo;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;
    
	@RequestMapping(value = "/deleteLibrary", method = RequestMethod.GET)
	public String deleteLibrary(Model model) {
		LibraryTo library = new LibraryTo();
		model.addAttribute("library", library);
		return "deleteLibrary";
	}
	
	@RequestMapping(value = "/deleteLibrary/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String deleteLibrary(@PathVariable("id") Long libraryId, Model model) {
		LibraryTo deletedLibrary;
		try {
			deletedLibrary = libraryService.delete(libraryId);
		} catch (IllegalArgumentException e) {
			return "redirect:/bookListInTable";
		}
		model.addAttribute("deletedLibrary", deletedLibrary);
		return "redirect:/bookListInTable";
	}
	
	@RequestMapping(value = "/deletedLibrary", method = RequestMethod.POST)
	public String deleteLibrary(Model model, LibraryTo library) {
		LibraryTo deletedLibrary = libraryService.delete(library.getId());
		model.addAttribute("deletedLibrary", deletedLibrary);
		return "redirect:/bookListInTable";
	}
}
