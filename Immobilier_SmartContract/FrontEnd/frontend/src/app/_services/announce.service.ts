import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Announce  } from '../models/announce';
import { Observable } from 'rxjs';

const ANNOUNCE_API = 'http://localhost:9191/Announce/';
const CONTRACT_API = 'http://localhost:9191/Ethereum/';
const AUTH_API     = 'http://localhost:9191/api/auth/';


@Injectable({
  providedIn: 'root'
})
export class AnnounceService {


  constructor(private http: HttpClient) { }


    public saveAnnounce(announce: Announce) {

      return this.http.post<Announce>(ANNOUNCE_API+'AddAnnounce' , announce);
    }

   public AnnouncesNotValidate(): Observable<Announce[]> {
         return this.http.get<Announce[]>(ANNOUNCE_API+'AnnouncesNotValidate');
       }

   public AnnouncesTrueValidate(): Observable<Announce[]> {
       return this.http.get<Announce[]>(ANNOUNCE_API+'AnnouncesTrueValidate');
     }

   public AnnouncesTrueValidateToPublish(): Observable<Announce[]> {
         return this.http.get<Announce[]>(ANNOUNCE_API+'AnnouncesTrueValidateToPublish');
      }

   public AnnouncesTrueValidatePublished(): Observable<Announce[]> {
            return this.http.get<Announce[]>(ANNOUNCE_API+'AnnouncesTrueValidatePublished');
         }

   public findAllAnnounces(): Observable<Announce[]> {
          return this.http.get<Announce[]>(ANNOUNCE_API+'Announce');
        }

    public AnnouncesNotPublishedYet(): Observable<Announce[]> {
              return this.http.get<Announce[]>(ANNOUNCE_API+'AnnouncesNotPublishedYet');
            }

    // validation=true or false in mongodb database
   public validate(title: String) {
        return this.http.put<Announce>(ANNOUNCE_API+'validate/'+title,null);
      }

   public reject(title: String) {
         return this.http.put<Announce>(ANNOUNCE_API+'rejectAnnounce/'+title,null);
      }

   public Publish(title: String){
        return this.http.put<Announce>(ANNOUNCE_API+'AddToPublication/'+title,null);
   }

   public RemovePublication(title: String){
           return this.http.put<Announce>(ANNOUNCE_API+'RemoveFromPublication/'+title,null);
      }

    public consulterAnnounceById(){
           return this.http.get<Announce[]>(ANNOUNCE_API+'consulterById');
    }

    public GetUserById(){
               return this.http.get<String>(ANNOUNCE_API+'GetUserById');
        }

    public getUserId(){
          // return this.http.get<String>(AUTH_API+'getid');
            //  return this.http.get<String>('http://localhost:9191/api/auth/getid');
            return this.http.get(AUTH_API+'getid',{responseType: 'text'});
    }

}
