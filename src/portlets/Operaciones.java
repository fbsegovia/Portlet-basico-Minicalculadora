package portlets;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


public class Operaciones extends GenericPortlet {
	
	@Override
	protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		String siguientePagina = request.getParameter("siguientePagina"); 
		if(siguientePagina == null){
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/introducirNumeros_view.jsp");
			prd.include(request, response);	
			
		}else if(siguientePagina.equals("introducirNumeros_view.jsp")){
			String error = request.getParameter("error");
			request.setAttribute("error", error);
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/introducirNumeros_view.jsp");
			prd.include(request, response);	
			
		}else if(siguientePagina.equals("resultado_view.jsp")){
			String sNumero3 = request.getParameter("numero3");
			String operacionSeleccionada = request.getParameter("operacion");
			request.setAttribute("numero3", sNumero3);
			request.setAttribute("operacion", operacionSeleccionada);
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/" + siguientePagina);
			prd.include(request, response);
		}
	}
	
	@Override
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		String accion = request.getParameter("accion");
		if(accion == null){
			return;
		}
		String siguientePagina = null;
		String sNumero1 = request.getParameter("numero1");
		String sNumero2 = request.getParameter("numero2");
		Integer iNumero1 = Integer.parseInt(sNumero1);
		Integer iNumero2 = Integer.parseInt(sNumero2);
		int numero3 =0;
			switch (accion) {
			case "sumar":
				numero3= iNumero1+iNumero2;
				siguientePagina = "resultado_view.jsp";
				break;
			case "restar":
				numero3= iNumero1-iNumero2;
				siguientePagina = "resultado_view.jsp";
				break;
			case "multiplicar":
				numero3= iNumero1*iNumero2;
				siguientePagina = "resultado_view.jsp";
				break;
			case "dividir":
				if(sNumero2.equals("0")){
					response.setRenderParameter("error", "No aceptamos divisiones por cero");
					siguientePagina = "introducirNumeros_view.jsp";
				}else{
					numero3= iNumero1/iNumero2;
					siguientePagina = "resultado_view.jsp";
				}
				break;
			default:
				break;
		}
		response.setRenderParameter("operacion", accion);
		response.setRenderParameter("numero3", ""+numero3);
		response.setRenderParameter("siguientePagina", siguientePagina);
	}
	
	
}
