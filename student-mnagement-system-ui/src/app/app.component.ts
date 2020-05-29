import { Component } from '@angular/core';
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
library.add(fas,);
import { faTachometerAlt,faCog, faFolder,faWrench,faChartArea,faTable,faBars,faLaughWink, faSearch, 
  faBell,faFileAlt,faDonate,faExclamationTriangle,faEnvelope,faUser,faCogs, faList, faSignOutAlt, faDownload} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  faTachometerAlt=faTachometerAlt;
  faCog=faCog;
  faFolder=faFolder;
  faWrench=faWrench;
  faChartArea=faChartArea;
  faTable=faTable;
  faBars=faBars;
  faLaughWink=faLaughWink;
  faSearch=faSearch;
  faBell=faBell;
  faFileAlt=faFileAlt;
  faDonate=faDonate;
  faExclamationTriangle=faExclamationTriangle;
  faEnvelope=faEnvelope;
  faUser=faUser;
  faCogs=faCogs;
  faList=faList;
  faSignOutAlt=faSignOutAlt;
  faDownload=faDownload;
  title = 'student-mnagement-system-ui';
}
