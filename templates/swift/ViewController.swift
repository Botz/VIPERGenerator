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
        title = JSUtils.LocalizedString("##MODULENAME_UPPERCASE##")

    }

    override func viewWillAppear(animated: Bool) {
        super.viewWillAppear(animated)
//        screenName = SCREEN_##MODULENAME_UPPERCASE##
        trackScreen()
    }

    override func shouldSetupMenuBarItem() -> Bool {
        return false
    }
}

// MARK: ##MODULENAME##ViewInterface

extension ##MODULENAME##ViewController: ##MODULENAME##ViewInterface {

}
