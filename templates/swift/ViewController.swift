//
//  ##MODULENAME##ViewController.swift
//  JSNow
//
//  Created by ##USERNAME## on ##DATE##.
//  Copyright © 2015 Jochen Schweizer GmbH. All rights reserved.
//

import XCGLogger

class ##MODULENAME##ViewController: JSViewController {

    var eventHandler: ##MODULENAME##ModuleInterface!

    override func viewDidLoad() {
        super.viewDidLoad()
        title = JSUtils.LocalizedString("CHANGE_LOCATION_TITLE")

    }

    override func viewWillAppear(animated: Bool) {
        super.viewWillAppear(animated)
        screenName = SCREEN_LOCATION_PICKER
        trackScreen()
    }

    override func shouldSetupMenuBarItem() -> Bool {
        return false
    }
}

// MARK: LocationPickerViewInterface

extension ##MODULENAME##ViewController: ##MODULENAME##ViewInterface {

}
