<div class="mdl-cell mdl-cell--12-col">
    <!-- Left aligned menu below button -->

    <button id="demo-menu-lower-left"
            class="mdl-button mdl-js-button mdl-button--icon">
        <i class="material-icons">more_vert</i>
    </button>

    <h6>Formulario de registo de Carreira de tecnicos administrativos</h6>

    <ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
        for="demo-menu-lower-left">
        <li class="mdl-menu__item">Some Action</li>
        <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another Action</li>
        <li disabled class="mdl-menu__item">Disabled Action</li>
        <li class="mdl-menu__item">Yet Another Action</li>
    </ul>
</div>

<div class="mdl-cell mdl-cell--1-col"></div>

<div class="mdl-cell mdl-cell--7-col">

<?php echo $this->Form->create('Cta'); ?>
<?php echo $this->Form->input('funcionario_id', array('type' => 'hidden')); ?>

    <div class="form-horizontal">
        <div class="form-group">
            <label for="FuncionarioNome" class="col-sm-2 control-label">Nome</label>
            <div class="col-sm-10">
      <?php echo $this->Form->input('Funcionario.nome', array('label'=>false, 'class' => 'form-control')); ?>
            </div>
        </div>
        <div class="form-group">
            <label for="FuncionarioApelido" class="col-sm-2 control-label">Apelido</label>
            <div class="col-sm-10">
      <?php echo $this->Form->input('Funcionario.apelido', array('label'=>false, 'class' => 'form-control')); ?>
            </div>
        </div>
        <div class="form-group">
   <?php echo $this->Form->label('Funcionario.sexo', 'Genero', array('class' => 'col-sm-2 control-label')); ?>
            <div class="col-sm-10">
      <?php echo $this->Form->radio('Funcionario.sexo', array('M' => 'Masculino', 'F' => 'Feminino'), array('legend' => false)); ?>
            </div>
        </div>
    </div>

    <hr>

    <div>
        <div class="form-group">
            <label for="Funcionario.Contacto_pessoal">Contacto pessoal</label>
    <?php echo $this->Form->input('Funcionario.contacto_pessoal', array('label'=>false, 'class' => 'form-control')); ?>
        </div>
        <div class="form-group">
            <label for="FuncionarioContactoAlternativo">Contacto alternativo</label>
    <?php   echo $this->Form->input('Funcionario.contacto_alternativo', array('label'=>false, 'class' => 'form-control')); ?>
        </div>
        <hr>  
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
            Submeter
        </button>
    </div>   
<?php echo $this->Form->end(); ?>
</div>
<!-- Tooltips para o formulario -->
<span class="mdl-tooltip" data-mdl-for="FuncionarioNome">Digite o nome do candidato</span>
<span class="mdl-tooltip" data-mdl-for="FuncionarioApelido">Digite o apelido do candidato</span>
<span class="mdl-tooltip" data-mdl-for="FuncionarioSexoF">Escolha se for femenino</span>
<span class="mdl-tooltip" data-mdl-for="FuncionarioSexoM">Escolha se for masculino</span>
<span class="mdl-tooltip" data-mdl-for="FuncionarioContactoPessoal">Contacto actualizado e funcional do concorrente</span>
<span class="mdl-tooltip" data-mdl-for="FuncionarioContactoAlternativo">Contacto actualizado do concorrente</span>

<div class="mdl-cell mdl-cell--3-col">
    <ul class="list-group">
        <a href="#" class="list-group-item active">
            Cras justo odio
        </a>
        <li class="list-group-item"><?php echo $this->Html->link("<span class='glyphicon glyphicon-th-list'></span> Lista de tecnicos", array('action' => 'index'), array('escape' => false)); ?></li>
        <li class="list-group-item"><?php echo $this->Html->link(__('List Funcionarios'), array('controller' => 'funcionarios', 'action' => 'index')); ?> </li>
        <li class="list-group-item"><?php echo $this->Html->link(__('New Funcionario'), array('controller' => 'funcionarios', 'action' => 'add')); ?> </li>
    </ul>
</div>
