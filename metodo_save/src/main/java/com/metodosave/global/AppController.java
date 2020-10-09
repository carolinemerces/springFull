package com.metodosave.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //serve para ligar o mysql com o front
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //no thymeleaf utiliza-se apenas o @controller
public class AppController {
	
	@Autowired //INJETAMOS O SERVICE NA CONTROLLER
	private ProdutoService service;
	
	//Model é um auxiliar que ajudara a adicionar atributos a nossa view(front) 
	
	@RequestMapping("/")
	public String showNewProdutoPage(Model model) {
		//cria um novo objeto na hora na tabela produto
		TableProduto produtoModel = new TableProduto();
		//coloca o objeto agora criado produtoModel na variavel produtoview
		model.addAttribute("produtoview", produtoModel); /* transforma em um objeto model capaz de aparecer como um produtoview*/
		//direciona o /new
		return "new_produto";
	}

	//url save amigavel , método post
		@RequestMapping(value = "/save", method = RequestMethod.POST) //assim que inserir os dados e dar um método post, vai aparecer a /save
		//insere o view na tabela por post
		public String saveProduto(@ModelAttribute("produtoview") TableProduto produto) {
			service.save(produto);
			
			return "redirect:/"; //redireciona para o início
		}
}
		
//		@RequestMapping("/edit/{id}")
//		public ModelAndView showEditProdutoPage(@PathVariable(name = "id") int id) {
//			ModelAndView mav = new ModelAndView("edit_produto");
//			Produto produto = service.get(id);
//			mav.addObject("produto", produto);
//			
//			return mav;
//		}
	//	
//		@RequestMapping("/delete/{id}")
//		public String deleteProduto(@PathVariable(name = "id") int id) {
//			service.delete(id);
//			return "redirect:/";	
			
//			@RequestMapping("/")
//			public String viewHomePage(Model model) {
//				List<Produto> listaProdutos = service.listAll();
//				model.addAttribute("listaProdutos", listaProdutos);
//				return "index";
			
		//}
		
		
		
	

