<div class="productos form">
<?php echo $this->Form->create('Producto'); ?>
	<fieldset>
		<legend><?php echo __('Add Producto'); ?></legend>
	<?php
		echo $this->Form->input('nome');
		echo $this->Form->input('sku');
		echo $this->Form->input('quantidade');
		echo $this->Form->input('descricao');
		echo $this->Form->input('foto');
		echo $this->Form->input('referencia');
		echo $this->Form->input('preco_aquisicao');
		echo $this->Form->input('data_de_registo');
		echo $this->Form->input('estoque_minimo');
		echo $this->Form->input('data_de_validade');
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Html->link(__('List Productos'), array('action' => 'index')); ?></li>
	</ul>
</div>
