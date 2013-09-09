/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import com.citybus.entidades.Localizacao;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author bluesprogrammer
 */
@Path("localizacao")
@RequestScoped
public class LocalizacaoResource {

    @Context
    private UriInfo context;

    public LocalizacaoResource() {
    }

    
    static List<Localizacao> localizacao;
    static{
         localizacao = new ArrayList<Localizacao>();
        
        localizacao.add(new Localizacao(1,-5.12233, -42.2343456));
        /*localizacao.add(new Localizacao(2,-5.667812, -42.5612323));
        localizacao.add(new Localizacao(3,-5.6678934, -42.50561234));*/
    
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Localizacao> obterLocalizacao(){
        return localizacao;
    }
    
    @GET
    @Path("{localizacao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Localizacao obterLocalizacao(@PathParam("localizacao") int idOnibus){
        return obterLocalizacao().get(idOnibus);
    }
    
    @POST
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public String insert(Localizacao l) {
       int j=0;
       for(Localizacao loc:localizacao){
           if(loc.getIdOnibus()==l.getIdOnibus()){
               j=1;
               loc.setLat(l.getLat());
               loc.setLongi(l.getLongi());
           }
       }
        if(l !=null&&j==0){
            localizacao.add(l);
            return "Localizacao inserida no banco!";
        }else{
            return "Erro ao adicionar localizacao";
        }
    }
}
