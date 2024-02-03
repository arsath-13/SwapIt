import { Injectable} from "@angular/core";
import { ActivatedRouteSnapshot,CanActivate,Router,RouterStateSnapshot } from "@angular/router";
import { LocalStorageService } from "../../services/storage-service/local-storage.service";

@Injectable({
  providedIn:'root'
})
export class AdminGuard implements CanActivate{

  constructor(private router:Router) {}

  canActivate(
    route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot
    ): any {
      if(LocalStorageService.isUserLoggedIn()) {
        this.router.navigateByUrl("/user/dashboard")
        alert(("ERROR! \n You don't have access of this page!!!"))
        return false;
      } else if(!LocalStorageService.hasToken()) {
        LocalStorageService.signOut();
        this.router.navigateByUrl("/login");
        alert(("ERROR! \n You are not logged in. Please Login First!!!"))
        return false
      }
      return true
  }
  
}

